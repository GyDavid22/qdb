export interface UserMetadata {
    id: number,
    userName: string,
    rank: "ADMIN" | "REGULAR" | "RESTRICTED" | "PENDING"
}