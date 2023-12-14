import React, {useState} from "react";
import { Button,Dialog, DialogTitle, DialogContent, TextField, DialogActions,Grid } from "@mui/material";


function ScoreForm({onAddScore}){

    const defaultFormData={
        golVisitante:"",
        golLocal:"",
        nrojas:"",
        namarillas:"", 
        equipoVisitante:"",
        equipoLocal:""
    }


    const [newScore, setNewScore] = useState(defaultFormData);

    const [open, setOpen] = useState(false);
    const handleSubmit = ev => {
        ev.preventDefault();
        onAddScore(newScore);
        handleClose();
    }
    const handleOpen = () =>{
        setOpen(true);
    }
    const handleClose = ()=>{
        setOpen(false);
        setNewScore(defaultFormData);
    }
    const handleChange = ev =>{
       const {name, value} = ev.target;
       setNewScore({...newScore, [name]:value})
    }



    return(

        <div>

            <Grid container
                direction="column"
                justifyContent="center"
                alignItems="center">
            <Button variant="contained" color="primary" onClick={handleOpen}>
                Digite el resultado del partido
            </Button>
            </Grid>
            
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>Add New Score</DialogTitle>
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
                    label="equipo visitante"
                    name="equipoVisitante"
                    value={newScore.equipoVisitante}
                    onChange={handleChange}
                    fullWidth
                    required
                    margin="normal"
                    />

<TextField
                    label="equipo local"
                    name="equipoLocal"
                    value={newScore.equipoLocal}
                    onChange={handleChange}
                    fullWidth
                    required
                    margin="normal"
                    />
                    <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button type="submit" color="primary" variant="contained">
                        Agregando los resultado del partido
                    </Button>
                    </DialogActions>
                </form>
                </DialogContent>
            </Dialog>

        </div>
    );

}

export default ScoreForm;