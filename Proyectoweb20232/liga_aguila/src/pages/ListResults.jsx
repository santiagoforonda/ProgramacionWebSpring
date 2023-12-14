import React, { useState } from "react";
import {useEffect} from "react";
import ScoreForm from "../components/ScoreForm";
import ScoreList from "../components/ScoreList";
import { CssBaseline, Typography, Grid, Box } from "@mui/material";
import "../estilosComponentes/ListResults.css";

const scoreData =[];


function ListResults(){


    const[scores,setScores]= useState(scoreData);

    useEffect(()=>{
        const fetchScores = async () =>{
            try {
                const response = await fetch("http://localhost:8080/api/v1/allScore");
                const scoreList = await response.json();
                const newScoresList = scoreList.map(t => ({"id":t.id,"golVisitante":t.golVisitante, "golLocal": t.golLocal, "nrojas":t.nrojas, "namarillas":t.namarillas, "equipoVisitante":t.equipoVisitante, "equipoLocal":t.equipoLocal}))
                setScores(newScoresList);
            } catch (error) {
                console.error('Error fetching teams: ', error);
            }
        }
        fetchScores();
    },[]);


    const handleAddScore = async (newScore) => {
        const newScoreToSend = {    
                                    "golVisitante":Number(newScore.golVisitante),
                                    "golLocal":Number(newScore.golLocal),
                                    "nrojas":Number(newScore.nrojas),
                                    "namarillas":Number(newScore.namarillas),
                                    "equipoVisitante":newScore.equipoVisitante,
                                    "equipoLocal":newScore.equipoLocal
                                    


                                  };
        try {
          const response = await fetch('http://localhost:8080/api/v1/score', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(newScoreToSend),
          });
    
          const data = await response.json();
          setScores((scores) => [...scores, {
            
           "golVisitante":data.golVisitante, 
          "golLocal": data.golLocal, 
          "nrojas":data.nrojas,
          "namarillas":data.namarillas,
          "equipoVisitante":data.equipoVisitante,
          "equipoLocal":data.equipoLocal
          
          }]);
        } catch (error) {
          console.error('Error al momento de agregar los resultados del partido:', error);
        }
      };

    return(
      <Box className="listaResultados">
        <CssBaseline />
        <Grid container spacing={2}>
          <Grid item sx={9}>
            <h3>Resultados parciales</h3>
            <div className="contenedor-resultados">
            <ScoreList scores={scores}></ScoreList>
            </div>
          </Grid>

          <Grid item sx={3}>
          <ScoreForm  onAddScore={handleAddScore}></ScoreForm>
          <Typography variant="p" component="p" align="center" gutterBottom >
            Ingrese un nuevo marcador
        </Typography>
          </Grid>
        
        
            
            </Grid>
        


      </Box>
        

        
        
    );
}

export default ListResults;