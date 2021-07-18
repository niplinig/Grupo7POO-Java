    public ArrayList<Observacion> tomarUnRango(Usuario usuario) {
        
        ArrayList <Observacion> listaResultante = new ArrayList<>();
        
        if (!usuario.getListDisp().isEmpty()) {
            for (Dispositivo dispositivos : usuario.getListDisp()) {
                for (Observacion observacion: dispositivos.listaObservaciones) {
                    if (observacion.getFecha().isAfter(fechaInicial) && observacion.getFecha().isBefore(fechaFinal)) {
                        listaResultante.add(observacion);
                    }
                }
            }
        }        
        return listaResultante;
    }
