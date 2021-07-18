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
