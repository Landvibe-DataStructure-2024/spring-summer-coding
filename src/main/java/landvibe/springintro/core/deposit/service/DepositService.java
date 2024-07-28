package landvibe.springintro.core.deposit.service;

public interface DepositService {
    void deposit(Long memberId, Long amount, String policy);

}
