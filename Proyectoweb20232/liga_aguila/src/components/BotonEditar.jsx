import React from "react";
import { Button, Dialog,DialogTitle, DialogContent,DialogActions,TextField } from "@mui/material";
import {useState} from "react";


function BotonEditar({resultado, resultados}){

    const infoToUpdate={
        "id":resultado.id,
        "golLocal":resultado.golLocal,
        "golVisitante": resultado.golVisitante,
        "namarillas":resultado.namarillas,
        "nrojas":resultado.nrojas,
        "equipoVisitante":resultado.equipoVisitante,
        "equipoLocal":resultado.equipoLocal
    }

    const [newScore, setNewScore] = useState(infoToUpdate);
    const [resultadosActuales, setResultadosActuales]= useState(resultados);
    const[editar, setEditar] = useState(false);
    const handleClose =()=>{
        setEditar(false);
        setNewScore(infoToUpdate);
    }

    const handleOpen =()=>{
        setEditar(true);
    }
    

   

    const handleChange = ev =>{
        const {name, value} = ev.target;
        setNewScore({...newScore, [name]:value})
     }

    



    const handleAddScore = async (newScore) => {
        const newScoreToSend = {    "id":newScore.id,
                                    "golVisitante":Number(newScore.golVisitante),
                                    "golLocal":Number(newScore.golLocal),
                                    "nrojas":Number(newScore.nrojas),
                                    "namarillas":Number(newScore.namarillas),
                                    "equipoVisitante":newScore.equipoVisitante,
                                    "equipoLocal":newScore.equipoLocal
                                    


                                  };
        try {
          const response = await fetch(`http://localhost:8080/api/v1/score/${newScore.id}`, {
            method: 'PUT',
            headers: {
              'Content-Type': 'application/json',
            },
            body: JSON.stringify(newScoreToSend),
          });
          const data = await response.json();
          for (let i = 0; i < resultadosActuales.length; i++) {
                if(data.id=== resultadosActuales.id){
                    setResultadosActuales(data);
                }
        }

        } catch (error) {
          console.error('Error al momento de agregar los resultados del partido:', error);
        }
      };

      const handleSubmit = ev => {
        ev.preventDefault();
        handleAddScore(newScore);
        handleClose();
    }

    return(
        <div>
             <Button variant="contained" color="primary" onClick={handleOpen}>
                Editar
            </Button>
        
       <Dialog open={editar} onClose={handleClose}>

       <DialogTitle>Agregue los nuevos resultados</DialogTitle>
                <DialogContent>
                <form onSubmit={handleSubmit}>
              

                    <TextField
                    label="goles del equipo visitante"
                    name="golVisitante"
                    value={newScore.golVisitante}
                    onChange={handleChange}
                    type ="number"
                    fullWidth
                    required
                    margin="normal"
                    />
                    <TextField
                    label="goles del equipo local"
                    name="golLocal"
                    value={newScore.golLocal}
                    onChange={handleChange}
                    type ="number"
                    fullWidth
                    required
                    margin="normal"
                    />
                    <TextField
                    label="numero de tarjetas rojas"
                    name="nrojas"
                    value={newScore.nrojas}
                    onChange={handleChange}
                    type="number"
                    fullWidth
                    required
                    margin="normal"
                    />

                    <TextField
                    label="numero de tarjetas amarillas"
                    name="namarillas"
                    value={newScore.namarillas}
                    onChange={handleChange}
                    type="number"
                    fullWidth
                    required
                    margin="normal"
                    />



<TextField
          disabled
          id="equipo visitante"
          label="Disabled"
          defaultValue={infoToUpdate.equipoVisitante}
        />

<TextField
          disabled
          id="equipo local"
          label="Disabled"
          defaultValue={infoToUpdate.equipoLocal}
        />

                    <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button type="submit" color="primary" variant="contained">
                        Nuevos resultados
                    </Button>
                    </DialogActions>
                </form>
                </DialogContent>
        </Dialog>
        </div>
    );
}

export default BotonEditar;