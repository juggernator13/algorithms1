public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);

        System.out.println("Список:");

        for (Integer value : list) {
            System.out.println(value);
        }

        System.out.println("Размер: " + list.size());
        System.out.println("Содержит 20: " + list.contains(20));
        System.out.println("Содержит 50: " + list.contains(50));

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println();
        System.out.println("Вершина стека: " + stack.peek());
        System.out.println("Удаление: " + stack.pop());
        System.out.println("Новая вершина: " + stack.peek());

        Calculator calculator =
                new Calculator();

        System.out.println();
        System.out.println(
                calculator.isBalanced("(a + b) * [c - d]")
        );

        System.out.println(
                calculator.isBalanced("{[()()]}")
        );

        System.out.println(
                calculator.isBalanced("([)]")
        );

        System.out.println(
                calculator.isBalanced("((a + b)")
        );

        System.out.println(
                calculator.isBalanced("")
        );

        System.out.println();

        System.out.println(
                calculator.evaluate("3 + 4 * 2")
        );

        System.out.println(
                calculator.evaluate("(3 + 4) * 2")
        );

        System.out.println(
                calculator.evaluate("10 / 2 - 3")
        );

        System.out.println(
                calculator.evaluate("2 * (3 + (4 - 1))")
        );

        try {
            System.out.println(
                    calculator.evaluate("5 / 0")
            );
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}