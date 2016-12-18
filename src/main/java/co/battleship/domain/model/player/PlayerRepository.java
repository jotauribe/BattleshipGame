package co.battleship.domain.model.player;

/**
 * Created by jotauribe on 16/12/16.
 */
public interface PlayerRepository {

    public Player playerOfId();

    public void save(Player player);

}
