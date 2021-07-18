    public static void addDevice(Device device) {
        if (device.canBeAdded()) {
            listDevices.add(device);
        }
        else {
            for (Device d: listDevices) {
                if (device.equals(d)) {
                    device.addAllObservation(d.getObservations());
                    device.addAllDates(d.getDates());
                }
            }
        }
    }

    public boolean canBeAdded() {
        if (Library.listIds.size() > 0) {
                if (!Library.listIds.contains(this.getId())) {
                    Library.listIds.add(this.getId());
                    return true;
                }
                else {
                    return false;
                }  
        }
        else {
            Library.listIds.add(this.getId());
            return true;
        }
    }
