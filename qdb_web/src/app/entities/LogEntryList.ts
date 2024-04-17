import { LogEntry } from "./LogEntry";

export interface LogEntryList {
    totalCount: number,
    results: LogEntry[];
}