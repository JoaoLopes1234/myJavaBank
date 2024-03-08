package Main.javabank.org.academiadecodigo.javabank.controller;

import Main.javabank.org.academiadecodigo.javabank.managers.AccountManager;
import Main.javabank.org.academiadecodigo.javabank.model.Bank;
import Main.javabank.org.academiadecodigo.javabank.model.account.Account;
import Main.javabank.org.academiadecodigo.javabank.model.account.AccountType;
import Main.javabank.org.academiadecodigo.javabank.view.NewAccountView;

/**
 * The {@link NewAccountView} controller
 */
public class NewAccountController extends AbstractController {

    private Bank bank;
    private Integer newAccountId;

    /**
     * Sets the bank
     *
     * @param bank the bank to set
     */
    public void setBank(Bank bank) {
        this.bank = bank;
    }

    /**
     * Gets the new account id
     *
     * @return the new account id
     */
    public Integer getNewAccountId() {
        return newAccountId;
    }

    /**
     * Creates a new {@link Account}
     *
     * @see Controller#init()
     * @see AccountManager#openAccount(AccountType)
     */
    @Override
    public void init() {

        newAccountId = createAccount();
        super.init();
    }

    private int createAccount() {

        Account newAccount = bank.getAccountManager().openAccount(AccountType.CHECKING);
        bank.getLoginCustomer().addAccount(newAccount);

        return newAccount.getId();
    }
}
