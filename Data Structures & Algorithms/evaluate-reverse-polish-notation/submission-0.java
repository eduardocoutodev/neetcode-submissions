class Solution {
    private final Set<String> operands = Set.of("+", "-", "*", "/");
    public int evalRPN(String[] tokens) {
        var stack = new ArrayDeque<String>();
        var sum = 0;

        for(String token: tokens){
            if(operands.contains(token)){
                // pop 2 last elements
                var b = Integer.parseInt(stack.pop());
                var a = Integer.parseInt(stack.pop());
                // do operation
                var result = doMathOperation(a, b, token);
                // push
                stack.push(result.toString());
            } else {
                stack.push(token);
            }
        }

        var finalResult = stack.pop();
        return Integer.parseInt(finalResult);
    }

    public Integer doMathOperation(int a, int b, String operation){
        return switch(operation){
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a/b;
            default -> throw new IllegalArgumentException();
        };
    }
}
