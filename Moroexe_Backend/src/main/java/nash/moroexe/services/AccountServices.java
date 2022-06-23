package nash.moroexe.services;

import nash.moroexe.data.entities.AccountEntity;
import nash.moroexe.dto.request.AccountRequestDTO;
import nash.moroexe.dto.response.AccountResponseDTO;

import java.util.List;

public interface AccountServices {
    List<AccountEntity> getAllAccount();
    AccountResponseDTO findAccountByIdDTO(Long id);
    AccountEntity findAccountById(Long id);
    AccountResponseDTO createAccount(AccountRequestDTO accountDTO);
    AccountResponseDTO updateAccount(AccountRequestDTO accountDTO, Long id);
    void deleteAccount(Long id);


}
