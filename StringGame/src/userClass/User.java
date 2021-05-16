package userClass;

public class User {

    private static User instance = null;

    //singleton implementation
    public static User getInstance()
    {
        if (instance == null)
        {
            instance = new User();
        }
        return instance;
    }//getInstance ends

    private String userName, userColor;
    private int userAge;

    public void collectUserData(String name, int age, String color)
    {
        this.userName = name;
        this.userAge = age;
        this.userColor = color;
    }

    //getter
    public String getUserName() {
        return userName;
    }

    public String getUserColor() {
        return userColor;
    }

    public int getUserAge() {
        return userAge;
    }
}
