package heaps;

public class Hospital {
    /**
     * reads patients from patients.csv
     * puts them into HospitalPatient objects
     * and adds them to a PriorityQueue.
     */
    public static void main(String[] args) {
        QueueInterface<HospitalPatient> pq = new PriorityQueue<>();
        // open patients.csv file for reading

        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File("patients.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[1].trim();
                try {
                    int priority = Integer.parseInt(parts[0].trim());
                    HospitalPatient patient = new HospitalPatient(name, priority);
                    pq.offer(patient);
                } catch (NumberFormatException e) {
                    // TODO: handle exception
                }

            }
        } catch (java.io.IOException e) {
            System.err.println("Error reading patients.csv: " + e.getMessage());
        }
        System.out.println("Patients in order of priority:");
        while (!pq.empty()) {
            HospitalPatient nextPatient = pq.poll();
            System.out.println(nextPatient);
        }

    }
}
