import React , { useState, useEffect }from "react";
import { CssBaseline, Typography, Grid,Box } from "@mui/material";
import TeamForm from "../components/TeamForm";
import TeamList from "../components/TeamList";
import "../estilosComponentes/RegisterTeam.css";

const teamsData = [];

function RegisterTeam(){
    const [teams, setTeams] = useState(teamsData);


    useEffect(()=>{
      const fetchTeams = async () =>{
          try {
              const response = await fetch("http://localhost:8080/api/v1/allTeams");
              const teamList = await response.json();
              const newTeamsList = teamList.map(t => ({"name":t.name, "bandera": t.bandera, "director":t.director}))
              setTeams(newTeamsList);
          } catch (error) {
              console.error('Error fetching teams: ', error);
          }
      }
      fetchTeams();
  },[]);

    const handleAddTeam = async (newTeam) => {
        const newTeamToSend = {"name":newTeam.name, 
                                  "bandera":newTeam.bandera , 
                                  "director": newTeam.director, 
                                  };
        try {
          const response = await fetch('http://localhost:8080/api/v1/team', {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(newTeamToSend),
          });
    
          const data = await response.json();
          setTeams((teams) => [...teams, {
           "name":data.name, 
          "bandera": data.bandera, 
          "director":data.director, 
          }]);
        } catch (error) {
          console.error('Error al momento de agregar el equipo a la liga:', error);
        }
      };
    return (
      <>
      <Box className="registroEquipos">
        <CssBaseline />
        <Grid container spacing={2}>
          <Grid item xs={6}>
              <h3>Equipos ya registrados en la liga aguila</h3>
              <div className="contenedor-lista-equipos">
              <TeamList teams={teams} />
              </div>
          </Grid>

          <Grid item xs={6}>
          <TeamForm onAddTeam= {handleAddTeam}/>
          <Typography variant="p" component="p" align="center" gutterBottom >
            Ingrese los datos para unir a su equipo a la liga aguila
          </Typography>
          </Grid>
        </Grid>
        
    </Box>

      
        
      </>
    );
}

export default RegisterTeam;