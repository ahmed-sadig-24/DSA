import java.util.Stack;

public class SimplifyPath {
      public static String simplifyPath(String path) {
            Stack<String> myStack = new Stack<>();
            StringBuilder res = new StringBuilder();
            String[] p = path.split("/");

            for (String str: p) {
                  //System.out.println(str);
                  //System.out.println(myStack.pop());
                  if (!myStack.isEmpty() && str.equals("..")) {
                        myStack.pop();
                  } else if (!str.equals("") && !str.equals(".") && !str.equals("..")) {
                        myStack.push(str);
                  }
            }

            //System.out.println(myStack.pop());

            //System.out.println(myStack.isEmpty());
            if (myStack.isEmpty()) return "/";

            while (!myStack.isEmpty()) {
                  //System.out.println(myStack.pop());
                  res.insert(0,myStack.pop()).insert(0,"/");
            }
            return res.toString();
      }

      public static void main(String[] args) {
            //String path = "/home/";
            //String path = "/home//foo/";
            String path = "/home/user/Documents/../Pictures";

            System.out.println(simplifyPath(path));
      }
}
