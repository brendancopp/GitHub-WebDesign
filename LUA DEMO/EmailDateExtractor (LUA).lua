
-- Data Arrays
numberRef = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}
numberString = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth", "twenty first", "twenty second", "twenty third", "twenty fourth", "twenty fifth", "twenty sixth", "twenty seventh", "twenty eight", "twenty ninth", "thirtieth", "thirty first"}

monthRef = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"}
monthRefShort = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"}

fileNameArray = {"Doug (Multiple month names).txt", "OfFile.txt", "Jeb (Short Month With Caps).txt", "Ex. Not actual file", "Bob (no date).txt"}

--Global Vars
currentFile = ""
stringStartPoint = 0
monthCount = 1
array = {}
stringSP = 0


--This program is designed to search through the text of several different documents, extract the dates, format the data, and then export to another document.

-- This program was designed with versitility in mind.

-- * This program works with wording such as : "January First", "January 1st", "1st of Jan", and will report an error (And the title of the invalid document)  if no such date is found in a file.
-- * This program also works around tricky wording such as : "Hello my name is january, and i would like to leave the First of June"

function main()

	local day
	local month

	list = io.open("~DATESLIST.txt", "w")
	list:write("List Of Emailed Dates \n\n-------------------------------\n")

	--Loops through 5 example files
	for i = 1, 5
	do
		--Checks if document exists
		if io.open(fileNameArray[i], "r") == nil then
			list:write("File name [ " .. fileNameArray[i] .. " ] was not found\n\n")
		else
			--Lowercases the whole document
			tempFile = io.open(fileNameArray[i], "r")
			currentFile = string.lower(tempFile:read("*a"))
			tempFile:close()

			--Searches for short month names Ex. Jan, Feb, Mar. If function return is invalid it will search long month names Ex. January, Febuary, March.
			array = monthRef
			monthIndex, day = search()
			month = monthRefShort[monthIndex]

			if month and day ~= nil
			then
				list:write("Date = " .. month .. " " .. day .. "   FileName - " .. fileNameArray[i] .. "\n\n")
			else
				array = monthRefShort
				monthIndex, day = search()
				month = monthRefShort[monthIndex]

				if month and day ~= nil
				then
				-- Valid date return
					list:write("Date = " .. month .. " " .. day .. "   FileName - " .. fileNameArray[i] .. "\n\n")

				-- Invalid date return
				else
					list:write("Please Manually Check File  -  " .. fileNameArray[i] .. "\n\n")
				end
			end
			currentFile = nil
		end

	end

	list:close()
end

--Search function
function search()
	stringSP = 0
	monthCount = 1

	while monthCount <= 12
	do

		Sindex, Eindex = string.find(currentFile, array[monthCount], stringSP)

		--Searches possibile locations of the day name, (Continues on if name not found)
		if Sindex ~= nil then

			--Searches with ofString function
			if ofString(Sindex) ~= nil then
				day = ofString(Sindex)
				return monthCount, day

			--Searches with stringNumber Function
			elseif stringNumber(Eindex) ~= nil then
				day = stringNumber(Eindex)
				return monthCount, day

			--Searches with number Function
			elseif number(Eindex) ~= nil then
				 day = number(Eindex)
				return monthCount, day
			end

			monthCount = 0
			stringSP = Eindex
		end
		monthCount = monthCount + 1

	end
	return nil, nil
end

function ofString(inSindex)

		--Searches instances of "Of" and extract day
		tempString = string.sub(currentFile, inSindex - 18, inSindex)

		for i = 31, 1, -1 do
			if i > 20 then
				if string.find(tempString, numberString[i]) ~= nil then
					day = numberRef[i]
					return numberRef[i]
				end
			else
				if string.find(tempString, numberString[i]) ~= nil then
					day = numberRef[i]
					return numberRef[i]
				end
			end
		end
		return nil

end

function stringNumber(inEindex)

	--Searches instances of "first, second, third" and extract day
	tempString = string.sub(currentFile, inEindex, inEindex + 15)

	for i = 31, 1, -1 do
		if i > 20 then
			if string.find(tempString, numberString[i]) ~= nil then
				day = numberRef[i]
				return numberRef[i]
			end
		else
			if string.find(tempString, numberString[i]) ~= nil then
				day = numberRef[i]
				return numberRef[i]
			end
		end
	end
	return nil
end

function number(inEindex)

	--Searches instances of "1st, 2nd, 3rd" and extract day
	tempString = string.sub(currentFile, inEindex, inEindex + 3)

	for i = 31, 1, -1 do
		if i >= 10 then
			if string.find(tempString, numberRef[i]) ~= nil then
				day = numberRef[i]
				return numberRef[i]
			end
		else
			if string.find(tempString, numberRef[i]) ~= nil then
				day = numberRef[i]
				return numberRef[i]
			end
		end
	end
	return nil
end

--Runs Main Code
main()
