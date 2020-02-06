class Foo {
    private boolean lockOne = false;
    private boolean lockTwo = false;
    
    public Foo() {
        
    }

    public  void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        lockOne = true;
    }

    
    public void second(Runnable printSecond) throws InterruptedException {

            while (!lockOne) { }  
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                lockTwo = true;            
            
    
        
    
    }
    public void third(Runnable printThird) throws InterruptedException {
        while (!lockTwo) { }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
            
        
    }
}