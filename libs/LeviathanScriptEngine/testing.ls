/*
 This is a test ls script
 */

@java("out")
flow test {

    def out
    
    {
        out.println("bob 1");
        out.println("bob 2");
        out.println("bob " + 3);
        int bob = 1 + 3
        String fred = "testing"
        def bob2 = "bob"
        out.println("fred " + bob );
        out.println("fred " + fred );
        out.println("fred " + bob2 );
        if (bob == 4) {
            out.println("test 1");
        } else {
            out.println("test 2");
        }
        if (fred.equals("testing")) {
            out.println("Called equals");
        } else {
            out.println("Failed to call equals");
        }
        while (bob < 8) {
            bob = bob + 1
            out.println("loop \"\\\n" + bob);
        }
        helloWorld()
        for (int test = 0; test < 2; test++) {
            out.println("for " + test);
        }

        def list = ["bob","fred"]
        out.println("list : " + list[0]);
        
        def map = ["key":"bob", "key1":"fred"]
        out.println("map : " + map["key1"]);
        
    }
    
    def helloWorld() {
        out.println("hello")
    }
}