package nash.moroexe.services;

import nash.moroexe.dto.request.AccountRequestDTO;
import nash.moroexe.dto.response.AccountResponseDTO;

import java.util.List;

public interface AccountServices {
    List<AccountResponseDTO> getAllAccount();

    AccountResponseDTO findAccountById(Long id);

    AccountResponseDTO createAccount(AccountRequestDTO accountDTO);

    AccountRequestDTO updateAccount(AccountRequestDTO accountDTO, Long id);

    void deleteAccount(Long id);


}
