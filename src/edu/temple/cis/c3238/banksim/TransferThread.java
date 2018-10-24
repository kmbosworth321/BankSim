package edu.temple.cis.c3238.banksim;
/**
 * @author Cay Horstmann
 * @author Modified by Paul Wolfgang
 * @author Modified by Charles Wang
 */
class TransferThread extends Thread {

    private final Bank bank;
    private final int fromAccount;
    private final int maxAmount;

    public TransferThread(Bank b, int from, int max) {
        bank = b;
        fromAccount = from;
        maxAmount = max;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if(!bank.isOpen()) {
                break;
            }
            int toAccount = (int) (bank.size() * Math.random());
            int amount = (int) (maxAmount * Math.random());            
            bank.transfer(fromAccount, toAccount, amount);
        }
        if(bank.isOpen()) {
            bank.closeBank();
            System.out.println("closed");
        }
    }
}
