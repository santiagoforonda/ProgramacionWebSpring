import React from "react";
import { Button,Dialog, DialogTitle, DialogContent, TextField, DialogActions,Grid } from "@mui/material";
import {useState} from "react";

function MatchForm({onAddMatch}){

    const defaultFormData = {
        fecha: '',
        estadio: '',
        equipoVisitante:'',
        equipoLocal:'',
        arbitro:''
    }

    const [newMatch, setNewMatch] = useState(defaultFormData);
    

    const [open, setOpen] = useState(false);
    const handleSubmit = ev => {
        ev.preventDefault();
        onAddMatch(newMatch);
        handleClose();
    }
    const handleOpen = () =>{
        setOpen(true);
    }
    const handleClose = ()=>{
        setOpen(false);
        setNewMatch(defaultFormData);
    }
    const handleChange = ev =>{
       const {name, value} = ev.target;
       setNewMatch({...newMatch, [name]:value})
    }

    return(

        <div>
            <Grid container
                direction="column"
                justifyContent="center"
                alignItems="center">
            <Button variant="contained" color="primary" onClick={handleOpen}>
                Agregando el partido
            </Button>
            </Grid>
            
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>Add New Match</DialogTitle>
                <DialogContent>
                <form onSubmit={handleSubmit}>
                    <TextField
                    
                    name="fecha"
                    value={newMatch.date}
                    onChange={handleChange}
                    type="date"
                    pattern="\d{2}-\d{2}-\d{4}"
                    fullWidth
                    required
                    margin="normal"
                    />
                    <TextField
                    label="estadio del partido"
                    name="estadio"
                    value={newMatch.estadio}
                    onChange={handleChange}
                    fullWidth
                    required
                    margin="normal"
                    />
                    
                    <TextField
                    label="nombre del equipo visitante"
                    name="equipoVisitante"
                    value={newMatch.equipoVisitante}
                    onChange={handleChange}
                    fullWidth
                    required
                    margin="normal"
                    />


<TextField
                    label="nombre  del equipo local"
                    name="equipoLocal"
                    value={newMatch.equipoLocal}
                    onChange={handleChange}
                    fullWidth
                    required
                    margin="normal"
                    />

<TextField
                    label="arbitro del partido"
                    name="arbitro"
                    value={newMatch.arbitro}
                    onChange={handleChange}
                    fullWidth
                    required
                    margin="normal"
                    />

                    
                    <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button type="submit" color="primary" variant="contained">
                        Agregando un nuevo partido a la liga aguila
                    </Button>
                    </DialogActions>
                </form>
                </DialogContent>
            </Dialog>


        </div>



    );
}

export default MatchForm;