package nash.moroexe.services.implement;

import nash.moroexe.data.entities.AccountEntity;
import nash.moroexe.data.repositories.AccountRepository;
import nash.moroexe.dto.request.AccountRequestDTO;
import nash.moroexe.dto.response.AccountResponseDTO;
import nash.moroexe.exceptions.AccountNotFoundException;
import nash.moroexe.services.AccountServices;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplement implements AccountServices {

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImplement(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AccountEntity> getAllAccount() {
        return this.accountRepository.findAll();
    }

    @Override
    public AccountResponseDTO findAccountByIdDTO(Long id) {
        Optional<AccountEntity> accountOptional = this.accountRepository.findById(id);
        if(accountOptional.isPresent()){
            AccountEntity accountEntity = accountOptional.get();
            AccountResponseDTO dto = new AccountResponseDTO();
            return modelMapper.map(accountOptional.get(),AccountResponseDTO.class);
        }
        throw new AccountNotFoundException(id);
    }

    @Override
    public AccountEntity findAccountById(Long id) {
        Optional<AccountEntity> optionalAccount = this.accountRepository.findById(id);
        if (optionalAccount.isPresent()) {
            return optionalAccount.get();
        }
        throw new AccountNotFoundException(id);
    }

    @Override
    public AccountResponseDTO createAccount(AccountRequestDTO accountDTO) {
        AccountEntity account = modelMapper.map(accountDTO,AccountEntity.class);
        AccountEntity savedAccount = accountRepository.save(account);
        return modelMapper.map(savedAccount,AccountResponseDTO.class);
    }

    @Override
    public AccountResponseDTO updateAccount(AccountRequestDTO accountDTO, Long id) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }
}
