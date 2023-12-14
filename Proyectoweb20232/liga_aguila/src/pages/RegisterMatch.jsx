import React from "react";
import {useState, useEffect} from "react";
import { CssBaseline, Typography, Grid, Box } from "@mui/material";
import MatchForm from "../components/MatchForm";
import MatchList from "../components/MatchList";
import "../estilosComponentes/RegisterMatch.css";
const matchsData = [
    
];

function RegisterMatch(){
    const [matchs, setMatch] = useState(matchsData);


    useEffect(()=>{
        const fetchMatch = async () =>{
            try {
                const response = await fetch("http://localhost:8080/api/v1/allMatchs");
                const matchList = await response.json();
                const newMatchsList = matchList.map(t => ({"fecha":t.fecha, "estadio": t.estadio, "equipoVisitante":t.equipoVisitante, "equipoLocal":t.equipoLocal, "arbitro":t.arbitro }))
                setMatch(newMatchsList);
            } catch (error) {
                console.error('Error fetching teams: ', error);
            }
        }
        fetchMatch();
    },[]);


    const handleAddMatch = async (newMatch) => {
        const newMatchToSend = {"fecha":newMatch.fecha, 
                                  "estadio": newMatch.estadio, 
                                  "equipoVisitante": newMatch.equipoVisitante, 
                                  "equipoLocal": newMatch.equipoLocal,
                                  "arbitro": newMatch.arbitro 
                                  };
        try {
          const response = await fetch('http://localhost:8080/api/v1/match', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(newMatchToSend),
          });
    
          const data = await response.json();
          setMatch((matchs) => [...matchs, {
           "fecha":data.fecha, 
          "estadio": data.estadio, 
          "equipoVisitante":data.equipoVisitante,
          "equipoLocal":data.equipoLocal,
          "arbitro":data.arbitro 
          }]);
        } catch (error) {
          console.error('Error al momento de agregar el equipo a la liga:', error);
        }
      };
    return(
      
      <>
         <Box className="registroPartidos">
        <CssBaseline />
        <Grid container spacing={2}>
          <Grid item xs={5}>
              <h3>Proximos partidos</h3>
              <div>
              <MatchList partidos={matchs}></MatchList>
              </div>
          </Grid>

          <Grid item xs={7}>
            <MatchForm onAddMatch= {handleAddMatch}/>
            <Typography variant="p" component="p" align="center" gutterBottom >
            Ingrese los datos para el partido
        </Typography>
          </Grid>
        
        
        </Grid>
      </Box>
      
      </>
   

      
       
            

            
        
    );
}

export default RegisterMatch;