export interface QuestionMetadata {
    id: number,
    title: string,
    tags: string[],
    imagesUrls: string[],
    createdBy: string,
    currentUserHasEditingRights: boolean
}
