package easy.blockchain;

import java.util.Date;


public class Block implements Cloneable {
    public String hash;
    public String previousHash;
    public Order order;
    public long timeStamp;
    
    public Block(Order order, String previousHash) {
        this.order = order;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        
        this.hash = HashGenerator.generateHash(
                this.previousHash 
                + this.timeStamp 
                + this.order.toString());
    }
    
    public static Block getGenesisBlock() {
        Order order = new Order("Its me", "Nothing", 0);
        Block block = new Block(order, "");
        block.timeStamp = 0;
        block.hash = HashGenerator.generateHash(
                block.previousHash 
                + block.timeStamp 
                + block.order.toString());
        return block;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
