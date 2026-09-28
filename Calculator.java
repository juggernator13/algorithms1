public class Calculator {

    public boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            else if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') {
                    return false;
                }

                if (c == ']' && top != '[') {
                    return false;
                }

                if (c == '}' && top != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public double evaluate(String expression) {

        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;

        while (i < expression.length()) {

            char c = expression.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            if (c == '(') {
                operators.push(c);
                i++;
                continue;
            }

            if (Character.isDigit(c) || c == '.') {

                StringBuilder number = new StringBuilder();

                while (i < expression.length()) {
                    char current = expression.charAt(i);

                    if (Character.isDigit(current) || current == '.') {
                        number.append(current);
                        i++;
                    } else {
                        break;
                    }
                }

                numbers.push(Double.parseDouble(number.toString()));
                continue;
            }

            if (c == ')') {

                while (!operators.isEmpty() && operators.peek() != '(') {
                    calculate(numbers, operators);
                }

                if (operators.isEmpty()) {
                    throw new IllegalArgumentException("Неправильные скобки.");
                }

                operators.pop();
                i++;
                continue;
            }

            if (isOperator(c)) {

                while (!operators.isEmpty()
                        && operators.peek() != '('
                        && priority(operators.peek()) >= priority(c)) {

                    calculate(numbers, operators);
                }

                operators.push(c);
                i++;
                continue;
            }

            throw new IllegalArgumentException(
                    "Недопустимый символ: " + c
            );
        }

        while (!operators.isEmpty()) {

            if (operators.peek() == '(') {
                throw new IllegalArgumentException("Неправильные скобки.");
            }

            calculate(numbers, operators);
        }

        if (numbers.size() != 1) {
            throw new IllegalArgumentException(
                    "Некорректное выражение."
            );
        }

        return numbers.pop();
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int priority(char operator) {

        if (operator == '+' || operator == '-') {
            return 1;
        }

        if (operator == '*' || operator == '/') {
            return 2;
        }

        return 0;
    }

    private void calculate(
            Stack<Double> numbers,
            Stack<Character> operators) {

        char operator = operators.pop();

        double right = numbers.pop();
        double left = numbers.pop();

        double result;

        switch (operator) {

            case '+':
                result = left + right;
                break;

            case '-':
                result = left - right;
                break;

            case '*':
                result = left * right;
                break;

            case '/':
                if (right == 0) {
                    throw new ArithmeticException(
                            "Деление на ноль."
                    );
                }

                result = left / right;
                break;

            default:
                throw new IllegalArgumentException(
                        "Неизвестный оператор."
                );
        }

        numbers.push(result);
    }
}