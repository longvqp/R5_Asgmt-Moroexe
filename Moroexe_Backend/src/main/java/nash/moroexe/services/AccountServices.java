package nash.moroexe.services;

import nash.moroexe.dto.request.AccountRequestDTO;
import nash.moroexe.dto.request.SignUpDTO;
import nash.moroexe.dto.response.AccountResponseDTO;

import java.util.List;

public interface AccountServices {
    List<AccountResponseDTO> getAllAccount();

    AccountResponseDTO findAccountById(Long id);

    AccountResponseDTO createAccount(SignUpDTO signUpDTO);
    AccountRequestDTO updateAccount(AccountRequestDTO accountDTO, Long id);
    String deleteAccount(Long id);


}
