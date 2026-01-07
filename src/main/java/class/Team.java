import org.ContinentEnum;
import java.util.List;
import java.util.ArrayList;

public class Team {

    private int id;
    private String name;
    private ContinentEnum continent;
    private List<Player> players;

    public Team() {
        players = new ArrayList<>();
    }

    public Team(int id, String name, ContinentEnum continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
        players = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContinentEnum getContinent() {
        return continent;
    }

    public void setContinent(ContinentEnum continent) {
        this.continent = continent;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setTeam(this);
    }

    public Integer getPlayersCount() {
        return players.size();
    }

    public Integer getPlayersGoals() {
        int total = 0;
        for (Player player : players) {
            if (player.getGoalNb() != null) {
                total += player.getGoalNb();
            }
        }
        return total;
    }
}
