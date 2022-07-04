package nash.moroexe.services.implement;

import nash.moroexe.data.entities.AccountEntity;
import nash.moroexe.data.entities.ERole;
import nash.moroexe.data.entities.RoleEntity;
import nash.moroexe.data.repositories.AccountRepository;
import nash.moroexe.data.repositories.RoleRepository;
import nash.moroexe.dto.request.AccountRequestDTO;
import nash.moroexe.dto.request.SignUpDTO;
import nash.moroexe.dto.response.AccountResponseDTO;
import nash.moroexe.exceptions.ResourceNotFoundException;
import nash.moroexe.services.AccountServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class AccountServiceImplement implements AccountServices, UserDetailsService {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;


    public AccountServiceImplement(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<AccountResponseDTO> getAllAccount() {
        List<AccountEntity> accounts = this.accountRepository.findAll();
        if (accounts.isEmpty()) {
            throw new ResourceNotFoundException("Can't find any account");
        } else {
            List<AccountResponseDTO> accountsDTO = new ArrayList<>();
            for (AccountEntity account : accounts) {
                AccountResponseDTO accountDTO = modelMapper.map(account, AccountResponseDTO.class);
                accountsDTO.add(accountDTO);
            }
            return accountsDTO;
        }
    }

    @Override
    public AccountResponseDTO findAccountById(Long id) {
        Optional<AccountEntity> accountOptional = this.accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            AccountEntity accountEntity = accountOptional.get();
            AccountResponseDTO dto = new AccountResponseDTO();
            return modelMapper.map(accountOptional.get(), AccountResponseDTO.class);
        }
        throw new ResourceNotFoundException("Can not found any account with ID= "+id);
    }


    @Override
    public AccountResponseDTO createAccount(SignUpDTO signUpRequest) {


        AccountEntity account = modelMapper.map(signUpRequest, AccountEntity.class);
        AccountEntity savedAccount = accountRepository.save(account);
        return modelMapper.map(savedAccount, AccountResponseDTO.class);
    }

    @Override
    public AccountRequestDTO updateAccount(AccountRequestDTO accountDTO, Long id) {
        Optional<AccountEntity> accountOptional = this.accountRepository.findById(id);
        if(!accountOptional.isPresent()){
            throw new ResourceNotFoundException("Can not found any account with ID= "+id);
        }else{
            AccountEntity account = accountOptional.get();
            modelMapper.map(accountDTO,account);
            this.accountRepository.save(account);
            return accountDTO;
        }
    }

    @Override
    public String deleteAccount(Long id) {
        return "Deleted";
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountEntity user = accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }
}
