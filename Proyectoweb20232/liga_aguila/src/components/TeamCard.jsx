import React from "react";
import { Card, CardContent, Typography } from "@mui/material";
import Avatar from '@mui/material/Avatar';

function TeamCard({team}){
    return (

        <div> 

            <Card style={{ margin: '10px', maxWidth: 700 }}>
                <CardContent>
                    <Typography color="text.secondary"><strong>Nombre del equipo: </strong> {team.name} </Typography>
                    <Avatar variant ="square" alt="Bnadera de equipo" src={team.bandera} sx={{width:56, height:56}} />
                    <Typography color="text.secondary"><strong>Director:</strong> {team.director}</Typography>
                </CardContent>
            </Card>

        </div>

    );
}

export default TeamCard;