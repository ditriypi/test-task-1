package User;

public class User implements IEmail,IPassword,IUserBuild,IUser,IConfirm {
    private String confirm;
    private String email;
    private String password;


    public static IEmail get(){
        return  new User();
    }



    @Override
    public IPassword setEmail(String email) {
        this.email = email;
        return this;
    }



    @Override
    public IUser build() {
        return this;
    }



    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getConfirm() {
        return confirm ;
    }

    @Override
    public IConfirm setPassword(String passwrd) {
        this.password = passwrd;
        return this;
    }

    @Override
    public IUserBuild setConfirm(String conf) {
        this.confirm = conf;
        return this;
    }
}

interface IUser{
    String getEmail();
    String getPassword();
    String getConfirm();

}


interface IEmail{
    IPassword setEmail(String email);
}
interface IPassword{
    IConfirm setPassword(String passwrd);
}
interface IConfirm{
     IUserBuild setConfirm(String conf);
}


interface IUserBuild{

    IUser build();
}