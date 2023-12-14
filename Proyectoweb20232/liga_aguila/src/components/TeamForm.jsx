import React, { useState } from "react";
import { Button,Dialog, DialogTitle, DialogContent, TextField, DialogActions,Grid } from "@mui/material";


function TeamForm({onAddTeam}){

    const defaultFormData = {
        name: '',
        bandera: '',
        director: ''
    }
    const [newTeam, setNewTeam] = useState(defaultFormData);

    const [open, setOpen] = useState(false);
    const handleSubmit = ev => {
        ev.preventDefault();
        onAddTeam(newTeam);
        handleClose();
    }
    const handleOpen = () =>{
        setOpen(true);
    }
    const handleClose = ()=>{
        setOpen(false);
        setNewTeam(defaultFormData);
    }
    const handleChange = ev =>{
       const {name, value} = ev.target;
       setNewTeam({...newTeam, [name]:value})
    }

    return (

        <div>
            <Grid container
                direction="column"
                justifyContent="center"
                alignItems="center">
            <Button variant="contained" color="primary" onClick={handleOpen}>
                Agregar equipo
            </Button>
            </Grid>
            
            <Dialog open={open} onClose={handleClose}>
                <DialogTitle>Add New Team</DialogTitle>
                <DialogContent>
                <form onSubmit={handleSubmit}>
                    <TextField
                    label="nombre del equipo"
                    name="name"
                    value={newTeam.name}
                    onChange={handleChange}
                    fullWidth
                    required
                    margin="normal"
                    />
                    <TextField
                    label="bandera"
                    name="bandera"
                    value={newTeam.bandera}
                    onChange={handleChange}
                    fullWidth
                    required
                    margin="normal"
                    />
                    <TextField
                    label="Director"
                    name="director"
                    value={newTeam.director}
                    onChange={handleChange}
                    fullWidth
                    required
                    margin="normal"
                    />
                    
                    <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button type="submit" color="primary" variant="contained">
                        Agregando un nuevo equipo a la liga aguila
                    </Button>
                    </DialogActions>
                </form>
                </DialogContent>
            </Dialog>

        </div>
    );
}

export default TeamForm;