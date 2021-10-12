package User;

public class UserRepository {

    private static   String EMAIL_NEW = DataGenerator.getEmail();
    private static   String EMAIL_EXIST = "kkurs0006@gmail.com";
    private static String PASSWORD_EXIST = "1234test";
    private static String  PASSWORD_NEW = "123LSQttLL";

   /*  public  User getExistUser(){
          User user = new User();
          user.setEmail(EMAIL_EXIST);
          user.setPassword(PASSWORD_EXIST);
          return user;

     }
     public User getWrongUser(){
         User user = new User();
         user.setEmail(EMAIL_EXIST);
         user.setPassword(PASSWORD_NEW);
         return user;
     }

     public User createNewUser(){
         User user = new User();
         user.setEmail(EMAIL_NEW);
         user.setPassword(PASSWORD_NEW);
         user.setConfirmPassword(PASSWORD_NEW);
         return user;
     }
     public User createInvalidUser(){
         User user = new User();
         user.setEmail(EMAIL_EXIST);
         user.setPassword(PASSWORD_NEW);
         user.setConfirmPassword(PASSWORD_NEW);
         return user;
     } */

   //Need Fix
    public static IUserBuild getExistUser() {
        return User.get().setEmail(EMAIL_EXIST).setPassword(PASSWORD_EXIST).setConfirm(PASSWORD_EXIST);
    }

    public static IUserBuild getNewUser(){
        return User.get().setEmail(DataGenerator.getEmail()).setPassword(PASSWORD_NEW).setConfirm(PASSWORD_NEW);
    }

    public static IUserBuild getUserWithWrongEmail(){
        return User.get().setEmail(DataGenerator.getEmail()).setPassword(PASSWORD_EXIST).setConfirm(PASSWORD_EXIST);
    }

    public static IUserBuild getUserWithWrongPassword(){
        return User.get().setEmail(EMAIL_EXIST).setPassword(PASSWORD_NEW).setConfirm(PASSWORD_EXIST);
    }


}