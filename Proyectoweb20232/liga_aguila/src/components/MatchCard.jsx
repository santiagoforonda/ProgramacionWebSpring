import React from "react";
import { Card, CardContent, Typography } from "@mui/material";

function MatchCard({match}){


    return(
        <div>
            <Card style={{ margin: '10px', maxWidth: 700 }}>
                <CardContent>
                    <Typography color="text.secondary" pattern="\d{2}-\d{2}-\d{4}"> <strong>Fecha del partido : </strong>{match.fecha} </Typography>
                    <Typography color="text.secondary"> <strong>Estadio del partido:</strong> {match.estadio}</Typography>
                    <Typography color="text.secondary"> <strong>Equipo visitante :</strong> {match.equipoVisitante}</Typography>
                    <Typography color="text.secondary"> <strong>Equipo local :</strong> {match.equipoLocal}</Typography>
                    <Typography color="text.secondary"><strong>Arbitro :</strong> {match.arbitro}</Typography>
                </CardContent>
            </Card>

        </div>
    );

}

export default MatchCard;