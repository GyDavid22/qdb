export interface LogEntry {
    id: number,
    time: string,
    userId: number,
    userName: string,
    action: string,
    roleAtTheMoment: string,
    wasPermissionGranted: boolean;
}