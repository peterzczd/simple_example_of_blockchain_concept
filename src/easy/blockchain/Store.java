package easy.blockchain;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;


public class Store extends Node implements Runnable {
    
    public Store(String address, Node connectedNode) {
        super(address, connectedNode);
    }
    
    public void testOrders() throws InterruptedException {
        String[] customerName = {"Customer1", "Customer2", "Customer3" };
        String[] orderDetails = {"Item1", "Item2", "Item3" };
        Random rand = new Random();
        
        for (int i = 0; i < 3; i++) {
            Block block = new Block(
                    new Order(customerName[rand.nextInt(3)], orderDetails[rand.nextInt(3)], rand.nextInt(50)),
                    this.blockChain.getLastHash()
            );
            try {
                this.mine(block);
                System.out.println(String.format("%s mined: %s", address, block.hash));
            } catch (IllegalArgumentException ex) {
                System.out.println(String.format("%s mined invalid block: %s", address, block.hash));
            }
            Thread.sleep(rand.nextInt(3) * 1000 + 100);
        }
    }
    
    public void printBlockChain() {
        System.out.println("..... Block chain of [" + address + "] .....");
        
        this.blockChain.getBlocks().forEach(block -> {
            System.out.println(block.hash);
        });
        
        System.out.println("..... END .....");
    }

    @Override
    public void run() {
        try {
            testOrders();
        } catch (InterruptedException ex) {
            Logger.getLogger(Store.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
