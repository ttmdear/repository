# without keyword
sampleFunction () {
    echo Hello from Sample Function.
}
 
sampleFunction

# with keyword
function sampleFunction {
    echo This is another way to define function in bash scripting.
}
 
sampleFunction

# bash function example with arguments
function functionWithArgs {
    echo $1 : $2 in this $3
}
 
functionWithArgs "`date +"[%m-%d %H:%M:%S]"`" "Learn Functions" "Bash Tutorial"
