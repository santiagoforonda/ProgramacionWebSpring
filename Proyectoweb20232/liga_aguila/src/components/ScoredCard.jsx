import React from "react";
import { Card, CardContent, Typography,Box } from "@mui/material";
import Avatar from '@mui/material/Avatar';
import "../estilosComponentes/ScoredCard.css";
import BotonEditar from "./BotonEditar";



function ScoreCard({resultado, resultados}){
    

    return(
       
        
        <Card style={{ margin: '10px', maxWidth: 700 }}>
            <CardContent className="contenedor-tarjeta">    
            <Box className="contenedor-goles">
                <Avatar variant ="square" alt="Bnadera de equipo" src={resultado.equipoLocal} sx={{width:56, height:56}} />
                <Typography variant="h3" color="text.secondary"><strong>{resultado.golLocal}</strong>  </Typography>
                <Typography variant="h3" color="text.secondary"><strong>:</strong>  </Typography>
                <Typography variant="h3" color="text.secondary"><strong> {resultado.golVisitante}</strong>   </Typography>
                <Avatar variant ="square" alt="Bnadera de equipo" src={resultado.equipoVisitante} sx={{width:56, height:56}} />
            </Box>
            <Box>
            <Typography color="text.secondary"><strong>Numero de amarillas :</strong> {resultado.namarillas}</Typography>
            <Typography color="text.secondary"><strong>Numero de rojas :</strong> {resultado.nrojas}</Typography>
            
            </Box>
            <BotonEditar resultado={resultado} resultados={resultados}></BotonEditar>
            </CardContent>
        </Card>
        
       
        
            
        
    );
}

export default ScoreCard;