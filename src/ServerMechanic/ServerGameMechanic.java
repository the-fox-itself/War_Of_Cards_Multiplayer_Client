package ServerMechanic;

import java.net.ServerSocket;

import static Libraries.Methods.*;

public class ServerGameMechanic {
    ServerSocket serverSocket;
    int port = 4000;
    public static boolean colorful_string = false;

    void start() {
        boolean inWhile = true;
        while (inWhile) {
            String userCommand = readLine();

            try {
                switch (userCommand.split(" ")[0]) {
                    case "help":
                        printUsedCommand("help");
                        help(userCommand);
                        break;
                    case "login":
                        printUsedCommand("login");
                        login(userCommand);
                        break;
                    case "color":
                        printUsedCommand("color");
                        color(userCommand);
                        break;
                    case "exit":
                        printUsedCommand("exit");
                        inWhile = false;
                        break;
                    default:
                        if (colorful_string) {
                            printNote("\"" + St_blue + userCommand.split(" ")[0] + St_red + "\" не является командой", NOTE_TYPE_ERROR);
                        } else {
                            printNote("\"" + userCommand.split(" ")[0] + "\" не является командой", NOTE_TYPE_ERROR);
                        }
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                printNote("Некорректный ввод", NOTE_TYPE_ERROR);
            }
        }
        printNote("Выключение программы", NOTE_TYPE_PROCESS);
        printNote("Программа благополучно выключена", NOTE_TYPE_DONE);
//        sendToServer("89.212.161.213", 4242, "login⊠" + userCommand.split(" ")[1] + "⊠" + userCommand.split(" ")[2]);

//        try {
//            serverSocket = new ServerSocket(port);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("<War Of Cards Server> Сервер успешно создан на порту №" + port + " и готов к использованию.");
    }

    void help(String userCommand) {
        if (userCommand.split(" ").length == 1) {
            if (colorful_string) {
                System.out.println(St_yellow +"<Helper>"+ St_reset +" Полный список команд:\n" +
                        St_cyan+"   Команда       Варианты использования        Описание\n"+
                        St_blue+"-  help"+St_yellow+"          help"+St_reset+"                          Выдает полный список команд с вариантами использования и описаниями.\n" +
                        St_blue+"                 "+St_yellow+"help *Команда*"+St_reset+"                Выдает варианты использования и описание введённой команды.\n" +
                        St_blue+"-  color"+St_yellow+"         color [true/false]"+St_reset+"            Включает/выключает разноцветный шрифт консоли.\n" +
                        St_blue+"-  login"+St_yellow+"         login *Ваш_ник* *Ваш_пароль*"+St_reset+"  Используется для входа в свой аккаунт в игре War Of Cards по нику и паролю.\n" +
                        St_blue+"-  exit"+St_yellow+"          exit"+St_reset+"                          Выключает программу War Of Cards Server.");
            } else {
                System.out.println("<Helper> Полный список команд:\n" +
                        "   Команда       Варианты использования        Описание\n" +
                        "-  help          help                          Выдает полный список команд с вариантами использования и описаниями.\n" +
                        "                 help *Команда*                Выдает варианты использования и описание введённой команды.\n" +
                        "-  color         color [true/false]            Включает/выключает разноцветный шрифт консоли.\n" +
                        "-  login         login *Ваш_ник* *Ваш_пароль*  Используется для входа в свой аккаунт в игре War Of Cards по нику и паролю.\n" +
                        "-  exit          exit                          Выключает программу War Of Cards Server.");
            }
        } else {
            if (colorful_string) {

            } else {
                switch (userCommand.split(" ")[1]) {
                    case "help":
                        System.out.println("<Helper> Команда help. Варианты использования: help. Выдает полный список команд с вариантами использования и описаниями.");
                        break;
                    default:
                        if (colorful_string) {
                            printNote("Helper", "\"" + St_blue + userCommand.split(" ")[1] + St_red + "\" не является командой", NOTE_TYPE_ERROR);
                        } else {
                            printNote("Helper", "\"" + userCommand.split(" ")[1] + "\" не является командой", NOTE_TYPE_ERROR);
                        }
                }
            }
        }
    }
    void login(String userCommand) {
        try {
            String nick = userCommand.split("\"")[1];
            String password = userCommand.split("\"")[3];
            printData("Ваш ник", nick);
            printData("Ваш пароль", password);
        } catch (ArrayIndexOutOfBoundsException ex) {
            IncorrectCommandUseException("login", "login \"*Your_nick*\" \"*Your_password*\"");
        }
    }
    void color(String userCommand) {
        try {
            if (userCommand.split(" ")[1].equals("true")) {
                colorful_string = true;
                printNote("Цветной текст включён", NOTE_TYPE_INFO);
            } else if (userCommand.split(" ")[1].equals("false")) {
                colorful_string = false;
                printNote("Цветной текст выключен", NOTE_TYPE_INFO);
            } else {
                IncorrectCommandUseException("color", "color [true/false]");
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            IncorrectCommandUseException("color", "color [true/false]");
        }
    }

    void printUsedCommand(String command) {
        if (colorful_string) {
            printNote("Используемая команда: \""+ St_blue +command+ St_reset +"\"", NOTE_TYPE_INFO);
        } else {
            printNote("Используемая команда: \""+command+"\"", NOTE_TYPE_INFO);
        }
    }
    void printData(String data_name, String data) {
        if (colorful_string) {
            printNote(data_name+": "+ St_blue +data+ St_reset, NOTE_TYPE_INFO);
        } else {
            printNote(data_name+": "+data, NOTE_TYPE_INFO);
        }
    }

    void IncorrectCommandUseException(String command, String correctUse) {
        if (colorful_string) {
            printNote("Некорректное использование команды \""+ St_blue +command+ St_red +"\". Правильное использование: \""+ St_blue +correctUse+ St_red +"\"", NOTE_TYPE_ERROR);
        } else {
            printNote("Некорректное использование команды \""+command+"\". Правильное использование: \""+correctUse+"\"", NOTE_TYPE_ERROR);
        }
    }
    void DataNoQuotesException() {
        if (colorful_string) {
            printNote("Вводимые данные необходимо помещать в кавычки. Например: "+ St_yellow +"\""+ St_blue +"Ваши_данные"+ St_yellow +"\""+ St_red, NOTE_TYPE_ERROR);
        } else {
            printNote("Вводимые данные необходимо помещать в кавычки. Например: \"Ваши_данные\"", NOTE_TYPE_ERROR);
        }
    }
}
