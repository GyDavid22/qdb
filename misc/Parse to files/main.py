import re
import json

class Question:
    def __init__(self) -> None:
        self.title: str
        self.body: str

def main():
    qlist = parseToList()
    count = 0
    qDictList: list[dict[str, str]] = []
    for i in qlist:
        with open(f"questions/q{count}.md", "wt", encoding="utf-8") as f:
            f.write(i.body)
        qDictList.append({
            "owner": None,
            "images": [],
            "title" : i.title,
            "body": f"q{count}.md",
            "tags": []
        })
        count += 1
    with open("questionsmetadata.json", "wt", encoding="utf-8") as f:
        f.write(json.dumps(qDictList))

def parseToList() -> list[Question]:
    qindex = 1
    qlist: list[Question] = []
    isInTitleMode = False
    currentlyLink = False
    currentQuestion: Question = None
    with open("out.md", "rt", encoding="utf-8") as f:
        for i in f:
            line = i.rstrip("\n").strip()
            if not currentlyLink:
                if re.search(r"^\[.*\]\(.*\)$", line) != None or re.search(r"^<http.*>$", line) != None:
                    continue
                elif re.search(r"^\[", line) != None or re.search(r"^<http", line) != None:
                    currentlyLink = True
                    continue
            elif currentlyLink:
                if re.search(r"\)$", line) != None or re.search(r">$", line) != None:
                    currentlyLink = False
                continue
            if line.startswith(f"{qindex}.") and not isInTitleMode:
                isInTitleMode = True
                if not currentQuestion == None:
                    qlist.append(currentQuestion)
                currentQuestion = Question()
                currentQuestion.title = line.lstrip(f"{qindex}. ")
                currentQuestion.body = ""
                qindex += 1
            elif isInTitleMode:
                if line == "":
                    isInTitleMode = False
                else:
                    currentQuestion.title += f" {line}"
            elif currentQuestion != None:
                currentQuestion.body += f"{line}\n"
        qlist.append(currentQuestion)
        postprocess(qlist)
    return qlist

def postprocess(qlist: list[Question]) -> None:
    for i in qlist:
        i.title = i.title.strip("**")
        i.title = i.title.replace("\\", "")
        i.body = i.body.rstrip("\n\n")
        i.body = i.body.replace("\\'", "'")
        while re.search(r"\n>*(\\>)+", i.body) != None:
            i.body = i.body.replace("\\>", ">", 1)
        i.body = re.sub(r'\){width=".*"[\n ]height=".*"}', "){}", i.body)
            
main()