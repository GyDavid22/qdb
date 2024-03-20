export interface UserMetadata {
    id: number,
    userName: string,
    rank: "SUPERUSER" | "ADMIN" | "NORMAL" | "RESTRICTED"
}