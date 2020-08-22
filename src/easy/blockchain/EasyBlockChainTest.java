package easy.blockchain;

import java.util.logging.Level;
import java.util.logging.Logger;


public class EasyBlockChainTest {

    public static void main(String[] args) {
        Store store1 = new Store("Store1", null);
        Store store2 = new Store("Store2", store1);
        Store store3 = new Store("Store3", store1);
        
        Store[] stores = {store1, store2, store3};
        
        for (Store store : stores) {
            Thread thread = new Thread(store);
            thread.start();
        }
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(EasyBlockChainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (Store store : stores) {
            System.out.println("");
            store.printBlockChain();
        }
    }
    
}
