package com.GetFit.resources;
import com.GetFit.dal.Macros;
import org.hibernate.SessionFactory;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Macro")
@Produces(MediaType.APPLICATION_JSON)
public class MacroResource {

    Macros macros;
    public MacroResource(Macros macros){
        this.macros = macros;
    }

}
