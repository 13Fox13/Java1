package tsystemtest;

import java.text.DecimalFormat;
import java.util.LinkedList;


public class CalculatorImpl implements Calculator {

    public CalculatorImpl(){}

    // Преобразовываем строку в обратную польскую запись
    @Override
    public String evaluate(String str) {
        try {
            LinkedList<Double> st = new LinkedList<>(); // используем LinkedList для возможности пользоваться removeLast
            LinkedList<Character> op = new LinkedList<>(); // замена стека храним операторы и цифры в порядке поступления для возможности пользоваться Stack
            DecimalFormat df = new DecimalFormat("##.####"); //для ответа в нужном виде
            for (int i = 0; i < str.length(); i++) { // парсим строку с выражением и вычисляем
                char c = str.charAt(i);
                if (isDelim(c))
                    continue;
                if (c == '(')
                    op.add('('); // добавляем элемент в конец списка методом add
                else if (c == ')') {
                    while (op.getLast() != '(') // получается последний элемент
                        processOperator(st, op.removeLast()); // после совершения с ним операции
                    op.removeLast(); // удаляется
                } else if (isOperator(c)) {
                    while (!op.isEmpty() && isPrior(op.getLast()) >= isPrior(c))
                        processOperator(st, op.removeLast());
                    op.add(c);
                } else {
//                    Операнды (аргументы) сначала извлекаются из стека,
//                    затем с ними выполняется операция, а
//                    результат операции помещается обратно в стек
                    String operand = "";
                    while (i < str.length() && Character.isDigit(str.charAt(i)) | str.charAt(i) == '.') {
                        operand += str.charAt(i++);
                    }
//                    Операнды из стека и на их место кладется результат,
//                    то есть при выполнении сложения глубина стека уменьшается на единицу.
//                    Вершина стека всегда содержит результат последней операции и высвечивается на д
                    i--;
                    st.add(Double.parseDouble(operand));
                }
            }
            while (!op.isEmpty())
                processOperator(st, op.removeLast());
            return df.format(st.get(0));// возвращаем полученный результат в нужном виде ##.####
        } catch (Exception ex) {
            return null;
        }
    }

    static boolean isDelim(char c) {
        return c == ' '; // true, если пробел
    }

    static boolean isOperator(char с) { // true, если знак
        return с == '+' || с == '-' || с == '*' || с == '/';
    }
//         Другие знаки операций не использовались, так как не требовались по заданию,
//         но их можно добавить, дописав необходимые кейсы

    static int isPrior(char op) {
        switch (op) { // расставляем приоритет операций, при + или - возврат 1, при * / 2 иначе -1
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    static void processOperator(LinkedList<Double> st, char operation) {
        double one = st.removeLast(); // берем 2 последних эллемента из листа и выполняем над ними операцию в зависимости от знака
        double two = st.removeLast();
        switch (operation) {
            case '+':
                st.add(two + one);
                break;
            case '-':
                st.add(two - one);
                break;
            case '*':
                st.add(two * one);
                break;
            case '/':
                st.add(two / one);
                break;
        }
    }
}