package resources;
import com.codahale.metrics.annotation.Timed;
import models.Macro;
import org.checkerframework.checker.units.qual.Time;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/Macro")
@Produces(MediaType.APPLICATION_JSON)
public class MacroResource {
    private final int protein;
    private final int carbs;
    private final int fats;

    public MacroResource(int protein, int carbs, int fats){
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }


    @GET
    @Timed
    public Macro macroGet() {
        Macro macro = Macro.builder().id(UUID.randomUUID().toString()).carbs(1).fats(1).protein(1).build();
        return macro;
    }
}
