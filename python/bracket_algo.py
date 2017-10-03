cnt = int(input())

strings = []
for _ in range(cnt):
    strings.append(input())

def bracket_check(context):
    brack_closed = {
        ')': '(',
        '}': '{',
        ']': '[',
    }
    bracket_open = ['(', '{', '[']
    brackets_stack = []

    for string in context:
        if string in bracket_open:
            brackets_stack.append(string)
        elif string in brack_closed:
            if len(brackets_stack) > 0:
                bracket_open_string = brackets_stack.pop()
                if bracket_open_string != brack_closed.get(string):
                    return False
            else:
                return False
    return True and len(brackets_stack) == 0

for s in strings:
    if bracket_check(s):
        print('YES')
    else:
        print('NO')
