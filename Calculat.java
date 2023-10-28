import java.util.Scanner;

public class Calculat {
     public static void main(String[] args) {
      
        Converter converter = new Converter();
        String[] operatia = {"+", "-", "/", "*"};
        String[] Chikloperatia = {"\\+", "-", "/", "\\*"};
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String one = scan.nextLine();

        //Определяем  действие
        int oper=-1;
        for (int i = 0; i < operatia.length; i++) {
            if(one.contains(operatia[i])){
                oper = i;
                break;
            }
        }
        //действие не то
        if(oper==-1){
            System.out.println("Некорректное выражение");
            return;
        }
        //Делим строчку по найденному арифметическому знаку


        String[] data = one.split(Chikloperatia[oper]);

        
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){//срваниваю либо рим либо араб
            int a,b;
         
            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){ // нашел рим и конвертирую в араб
             
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);

            }else{
                // если араб то из строки в числа
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            //арифметика
            int result;
            switch (operatia[oper]){
                case "+":
                    result = a+b;
                    break;
                case "-":
                    result = a-b;
                    break;
                case "*":
                    result = a*b;
                    break;
                default:
                    result = a/b;
                    break;
            }
          
            if(isRoman){
                
                System.out.println(converter.intToRoman(result)); // если рим возврат в рим

            }
           
            else{
                //если числа были арабские, возвращаем результат в арабском числе
                System.out.println(result);
            }
            if(result > 10){System.out.println("Сумма должна быть не больше 10");} // исключение для арабских и римских чисел больше 10
            if (result < 0){System.out.println("Сумма не должна быть меньше 0");}// исключение для арабских меньше 0
        }else{
            System.out.println("Числа должны быть в одном формате");
        }
        
            //Результат выводится но выходит исключение)
            //Пытался сделать без конвертора используя только массив + switch перспектива такая себе...
    } 
}
