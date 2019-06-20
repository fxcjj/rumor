package com.vic.small;

public class CallbackTest {
    
    public static String execute(Parking parking) {
        //do my business
        //callback parking
    	if(true) { //some condition
    		parking.feedback();
    	}
        return "finished";
    }
    
    public static void main(String[] args) {
        String rst = CallbackTest.execute(new Parking() {
            
            public void feedback() {
                System.out.println("Parking feedback()");
            }
            
        });
        
        System.out.println(rst);
        
    }
    
}

interface Parking {
    
    void feedback();
    
}

