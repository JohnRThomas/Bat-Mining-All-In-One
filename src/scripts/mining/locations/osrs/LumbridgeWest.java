package scripts.mining.locations.osrs;

import com.runemate.game.api.hybrid.location.Area;
import com.runemate.game.api.hybrid.location.Coordinate;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import scripts.mining.AIOMinerGUI;
import scripts.mining.Rock;

public class LumbridgeWest extends OSRSLocation{

	@Override
	public void intialize(String ore) {
		switch(ore){
		case "Coal":
			rocks = new Coordinate[]{new Coordinate(3145,3153),new Coordinate(3144,3152),new Coordinate(3145,3151),new Coordinate(3146,3151),new Coordinate(3144,3150),new Coordinate(3145,3149),new Coordinate(3144,3148)};
			break;
		case "Mithril":
			rocks = new Coordinate[]{new Coordinate(3144,3145),new Coordinate(3144,3147),new Coordinate(3143,3146),new Coordinate(3146,3145),new Coordinate(3148,3144)};
			break;
		case "Adamantite":
			rocks = new Coordinate[]{new Coordinate(3147,3146),new Coordinate(3148,3147)};
			break;
		default:
			throw new RuntimeException(ore + " is not supported in " + getName());
		}
		this.ore = Rock.getByName(ore);
		bank = new Area.Rectangular(new Coordinate(3091,3245), new Coordinate(3096,3241));
		mine = new Area.Rectangular(new Coordinate(3150,3155), new Coordinate(3141,3143));
	}

	@Override
	public String getName() {
		return "Lumbridge West";
	}

	@Override
	public String[] getOres() {
		return new String[]{"Coal", "Mithril", "Adamantite"};
	}

	@Override
	public Node[] getSettingsNodes(){
		ImageView warnImage = AIOMinerGUI.warnImage;
		Label labela = new Label("WARNING!");
		labela.setStyle("-fx-text-fill: -fx-text-input-text");
		labela.setPadding(new Insets(0,0,3,5));
		labela.setPrefWidth(165);
		labela.setGraphic(warnImage);

		Label labelb = new Label("This area may be");
		labelb.setStyle("-fx-text-fill: -fx-text-input-text");
		labelb.setPadding(new Insets(0,0,3,5));
		labelb.setPrefWidth(165);
		
		Label labelc = new Label("buggy due to counter");
		labelc.setStyle("-fx-text-fill: -fx-text-input-text");
		labelc.setPadding(new Insets(0,0,3,5));
		labelc.setPrefWidth(165);	
		
		Label labeld = new Label("measures by Jagex.");
		labeld.setStyle("-fx-text-fill: -fx-text-input-text");
		labeld.setPadding(new Insets(0,0,3,5));
		labeld.setPrefWidth(165);
		
		return new Node[]{labela, labelb, labelc, labeld};
	}
	
/* Commented this section out since it stopped the miner from seeing OSRS rocks.
	public boolean validate(GameObject rock) {
		GameObjectDefinition def = rock.getDefinition();
		String name = "";
		if(def != null)name = def.getName();

		return !name.equals("Rocks") && name.contains("rocks") && (name.contains("ore") || rock.getAnimationId() > 0);
	}
*/
}
