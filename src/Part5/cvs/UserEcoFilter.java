package Part5.cvs;

import java.util.ArrayList;
import java.util.List;

public class UserEcoFilter implements UserFilter {
    private final int maxConsumption;
    public UserEcoFilter(int maxConsumption) {
        this.maxConsumption = maxConsumption;
    }
    private boolean isEcological(User user) {
        return (user.getWaterCount() < maxConsumption &&
                user.getGasCount1() < maxConsumption &&
                user.getGasCount2() < maxConsumption &&
                user.getElectroCount1() < maxConsumption &&
                user.getElectroCount2() < maxConsumption);
    }
    @Override
    public User[] filter(User[] users) {

        List<User> ecoUsers = new ArrayList<>();
        for (User user: users) {
            if (isEcological(user)) {
                ecoUsers.add(user);
            }
        }
        return ecoUsers.toArray(new User[0]);
    }


}
