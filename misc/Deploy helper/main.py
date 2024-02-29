# Place this file into the folder of the built Angular project to deploy and it will update
# root paths where necessary

import os

ROOT_PATH = '/java'
class Globals:
    NUM_OF_REPLACES = 0

def main():
    traverse(os.listdir())
    print(f"Replaced text {Globals.NUM_OF_REPLACES} times")

def traverse(root: list[str], prefix = ""):
    for i in root:
        filename = prefix + i
        if os.path.isfile(filename) and filename.endswith(".html"):
            postprocess(filename)
        elif os.path.isdir(filename):
            traverse(os.listdir(filename), prefix + i + "/")

def postprocess(filepath: str):
    filecontent: str = ""
    with open(filepath, "rt", encoding="utf-8") as f:
        filecontent = f.read()
    filecontent = replace('src="', filecontent)
    filecontent = replace('href="', filecontent)
    with open(filepath, "wt", encoding="utf-8") as f:
        f.write(filecontent)

def replace(textToReplace: str, text: str):
    continueLooking = True
    index = 0
    replaceValue = f"{textToReplace}{ROOT_PATH}/"
    while continueLooking:
        try:
            currentIndex = text.index(textToReplace, index)
            start = currentIndex + len(textToReplace)
            end = start + len(ROOT_PATH)
            currentTextToExamine = text[start:end]
            if not currentTextToExamine == ROOT_PATH:
                text = text[:currentIndex] + replaceValue + text[start:]
                Globals.NUM_OF_REPLACES += 1
                index = currentIndex + len(replaceValue)
            else:
                index = currentIndex + len(textToReplace)
        except ValueError as e:
            continueLooking = False
    return text

main()