export interface QuestionMetadata {
    id: number,
    title: string,
    bodyUrl: string,
    tags: string[],
    imagesUrls: string[],
    createdBy: string,
    currentUserHasEditingRights: boolean
}
